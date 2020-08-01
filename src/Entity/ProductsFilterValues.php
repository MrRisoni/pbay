<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ProductsFilterValues
 *
 * @ORM\Table(name="products_filter_values", uniqueConstraints={@ORM\UniqueConstraint(name="pfv_product_id_2", columns={"pfv_product_id", "pfv_filter_id"})}, indexes={@ORM\Index(name="pfv_filter_id", columns={"pfv_filter_id"}), @ORM\Index(name="pfv_product_id", columns={"pfv_product_id"})})
 * @ORM\Entity
 */
class ProductsFilterValues
{
    /**
     * @var int
     *
     * @ORM\Column(name="pfv_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $pfvId;

    /**
     * @var string
     *
     * @ORM\Column(name="pfv_value", type="string", length=88, nullable=false)
     */
    private $pfvValue;

    /**
     * @var \ProductsFilters
     *
     * @ORM\ManyToOne(targetEntity="ProductsFilters")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="pfv_filter_id", referencedColumnName="fil_id")
     * })
     */
    private $pfvFilter;

    /**
     * @var \Products
     *
     * @ORM\ManyToOne(targetEntity="Products")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="pfv_product_id", referencedColumnName="prod_id")
     * })
     */
    private $pfvProduct;

    public function getPfvId(): ?int
    {
        return $this->pfvId;
    }

    public function getPfvValue(): ?string
    {
        return $this->pfvValue;
    }

    public function setPfvValue(string $pfvValue): self
    {
        $this->pfvValue = $pfvValue;

        return $this;
    }

    public function getPfvFilter(): ?ProductsFilters
    {
        return $this->pfvFilter;
    }

    public function setPfvFilter(?ProductsFilters $pfvFilter): self
    {
        $this->pfvFilter = $pfvFilter;

        return $this;
    }

    public function getPfvProduct(): ?Products
    {
        return $this->pfvProduct;
    }

    public function setPfvProduct(?Products $pfvProduct): self
    {
        $this->pfvProduct = $pfvProduct;

        return $this;
    }


}
