<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ProductsCategories
 *
 * @ORM\Table(name="products_categories")
 * @ORM\Entity
 */
class ProductsCategories
{
    /**
     * @var int
     *
     * @ORM\Column(name="cat_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $catId;

    /**
     * @var string
     *
     * @ORM\Column(name="cat_title", type="string", length=255, nullable=false)
     */
    private $catTitle;

    public function getCatId(): ?int
    {
        return $this->catId;
    }

    public function getCatTitle(): ?string
    {
        return $this->catTitle;
    }

    public function setCatTitle(string $catTitle): self
    {
        $this->catTitle = $catTitle;

        return $this;
    }


}
