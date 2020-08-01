<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * Days
 *
 * @ORM\Table(name="days", uniqueConstraints={@ORM\UniqueConstraint(name="index_days_on_name", columns={"name"})})
 * @ORM\Entity
 */
class Days
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
     * @ORM\Column(name="name", type="string", length=255, nullable=true)
     */
    private $name;

    /**
     * @ORM\OneToMany(targetEntity=Timetablings::class, mappedBy="tag")
     */
    private $timetablings;

    public function __construct()
    {
        $this->timetablings = new ArrayCollection();
    }

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(?string $name): self
    {
        $this->name = $name;

        return $this;
    }

    /**
     * @return Collection|Timetablings[]
     */
    public function getTimetablings(): Collection
    {
        return $this->timetablings;
    }

    public function addTimetabling(Timetablings $timetabling): self
    {
        if (!$this->timetablings->contains($timetabling)) {
            $this->timetablings[] = $timetabling;
            $timetabling->setTag($this);
        }

        return $this;
    }

    public function removeTimetabling(Timetablings $timetabling): self
    {
        if ($this->timetablings->contains($timetabling)) {
            $this->timetablings->removeElement($timetabling);
            // set the owning side to null (unless already changed)
            if ($timetabling->getTag() === $this) {
                $timetabling->setTag(null);
            }
        }

        return $this;
    }


}
