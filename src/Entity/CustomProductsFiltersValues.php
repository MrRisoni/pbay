<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CustomProductsFiltersValues
 *
 * @ORM\Table(name="custom_products_filters_values", indexes={@ORM\Index(name="csp_filter_id", columns={"csp_filter_id"}), @ORM\Index(name="csp_selling_id", columns={"csp_selling_id"})})
 * @ORM\Entity
 */
class CustomProductsFiltersValues
{
    /**
     * @var int
     *
     * @ORM\Column(name="csp_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $cspId;

    /**
     * @var string
     *
     * @ORM\Column(name="csp_value", type="string", length=45, nullable=false)
     */
    private $cspValue;

    /**
     * @var \ProductsFilters
     *
     * @ORM\ManyToOne(targetEntity="ProductsFilters")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="csp_filter_id", referencedColumnName="fil_id")
     * })
     */
    private $cspFilter;

    /**
     * @var \Selling
     *
     * @ORM\ManyToOne(targetEntity="Selling")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="csp_selling_id", referencedColumnName="sll_id")
     * })
     */
    private $cspSelling;

    public function getCspId(): ?int
    {
        return $this->cspId;
    }

    public function getCspValue(): ?string
    {
        return $this->cspValue;
    }

    public function setCspValue(string $cspValue): self
    {
        $this->cspValue = $cspValue;

        return $this;
    }

    public function getCspFilter(): ?ProductsFilters
    {
        return $this->cspFilter;
    }

    public function setCspFilter(?ProductsFilters $cspFilter): self
    {
        $this->cspFilter = $cspFilter;

        return $this;
    }

    public function getCspSelling(): ?Selling
    {
        return $this->cspSelling;
    }

    public function setCspSelling(?Selling $cspSelling): self
    {
        $this->cspSelling = $cspSelling;

        return $this;
    }


}
