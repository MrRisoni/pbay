<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ProductsFilters
 *
 * @ORM\Table(name="products_filters", uniqueConstraints={@ORM\UniqueConstraint(name="fil_title", columns={"fil_title"})}, indexes={@ORM\Index(name="fil_product_category", columns={"fil_product_category"})})
 * @ORM\Entity
 */
class ProductsFilters
{
    /**
     * @var int
     *
     * @ORM\Column(name="fil_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $filId;

    /**
     * @var string
     *
     * @ORM\Column(name="fil_title", type="string", length=55, nullable=false)
     */
    private $filTitle;

    /**
     * @var \ProductsCategories
     *
     * @ORM\ManyToOne(targetEntity="ProductsCategories")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="fil_product_category", referencedColumnName="cat_id")
     * })
     */
    private $filProductCategory;

    public function getFilId(): ?int
    {
        return $this->filId;
    }

    public function getFilTitle(): ?string
    {
        return $this->filTitle;
    }

    public function setFilTitle(string $filTitle): self
    {
        $this->filTitle = $filTitle;

        return $this;
    }

    public function getFilProductCategory(): ?ProductsCategories
    {
        return $this->filProductCategory;
    }

    public function setFilProductCategory(?ProductsCategories $filProductCategory): self
    {
        $this->filProductCategory = $filProductCategory;

        return $this;
    }


}
