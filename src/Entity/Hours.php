<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Hours
 *
 * @ORM\Table(name="hours", uniqueConstraints={@ORM\UniqueConstraint(name="index_hours_on_title", columns={"title"})})
 * @ORM\Entity
 */
class Hours
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


}
