<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * WishCategories
 *
 * @ORM\Table(name="wish_categories", uniqueConstraints={@ORM\UniqueConstraint(name="index_wish_categories_on_title", columns={"title"})})
 * @ORM\Entity
 */
class WishCategories
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
     * @ORM\Column(name="title", type="string", length=80, nullable=true)
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
