<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * ProjectStages
 *
 * @ORM\Table(name="project_stages")
 * @ORM\Entity
 */
class ProjectStages
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
     * @var \DateTime
     *
     * @ORM\Column(name="created_at", type="datetime", nullable=false)
     */
    private $createdAt;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="updated_at", type="datetime", nullable=false)
     */
    private $updatedAt;

    /**
     * @ORM\OneToMany(targetEntity=Tasks::class, mappedBy="projectStages")
     */
    private $tasksList;

    public function __construct()
    {
        $this->tasksList = new ArrayCollection();
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

    public function getCreatedAt(): ?\DateTimeInterface
    {
        return $this->createdAt;
    }

    public function setCreatedAt(\DateTimeInterface $createdAt): self
    {
        $this->createdAt = $createdAt;

        return $this;
    }

    public function getUpdatedAt(): ?\DateTimeInterface
    {
        return $this->updatedAt;
    }

    public function setUpdatedAt(\DateTimeInterface $updatedAt): self
    {
        $this->updatedAt = $updatedAt;

        return $this;
    }

    /**
     * @return Collection|Tasks[]
     */
    public function getTasksList(): Collection
    {
        return $this->tasksList;
    }

    public function addTasksList(Tasks $tasksList): self
    {
        if (!$this->tasksList->contains($tasksList)) {
            $this->tasksList[] = $tasksList;
            $tasksList->setProjectStages($this);
        }

        return $this;
    }

    public function removeTasksList(Tasks $tasksList): self
    {
        if ($this->tasksList->contains($tasksList)) {
            $this->tasksList->removeElement($tasksList);
            // set the owning side to null (unless already changed)
            if ($tasksList->getProjectStages() === $this) {
                $tasksList->setProjectStages(null);
            }
        }

        return $this;
    }


}
