<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * WishLists
 *
 * @ORM\Table(name="wish_lists", indexes={@ORM\Index(name="index_wish_lists_on_wish_categories_id", columns={"wish_categories_id"})})
 * @ORM\Entity
 */
class WishLists
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

    /**
     * @var \WishCategories
     *
     * @ORM\ManyToOne(targetEntity="WishCategories")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="wish_categories_id", referencedColumnName="id")
     * })
     */
    private $wishCategories;

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

    public function getWishCategories(): ?WishCategories
    {
        return $this->wishCategories;
    }

    public function setWishCategories(?WishCategories $wishCategories): self
    {
        $this->wishCategories = $wishCategories;

        return $this;
    }


}
