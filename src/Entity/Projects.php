<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * Projects
 *
 * @ORM\Table(name="projects")
 * @ORM\Entity
 */
class Projects
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="bigint", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string|null
     *
     * @ORM\Column(name="title", type="string", length=255, nullable=true)
     */
    private $title;

    /**
     * @ORM\OneToMany(targetEntity=Tasks::class, mappedBy="projects")
     */
    private $taskLists;

    public function __construct()
    {
        $this->taskLists = new ArrayCollection();
    }

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getTitle(): ?string
    {
        return $this->title;
    }

    public function setTitle(?string $title): self
    {
        $this->title = $title;

        return $this;
    }

    
    /**
     * @return Collection|Tasks[]
     */
    public function getTaskLists(): Collection
    {
        return $this->taskLists;
    }

    public function addTaskList(Tasks $taskList): self
    {
        if (!$this->taskLists->contains($taskList)) {
            $this->taskLists[] = $taskList;
            $taskList->setProjects($this);
        }

        return $this;
    }

    public function removeTaskList(Tasks $taskList): self
    {
        if ($this->taskLists->contains($taskList)) {
            $this->taskLists->removeElement($taskList);
            // set the owning side to null (unless already changed)
            if ($taskList->getProjects() === $this) {
                $taskList->setProjects(null);
            }
        }

        return $this;
    }


}
