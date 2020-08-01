<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ShippingCostsExceptions
 *
 * @ORM\Table(name="shipping_costs_exceptions", indexes={@ORM\Index(name="shc_selling_id", columns={"shcx_selling_id"}), @ORM\Index(name="shc_country_id", columns={"shcx_country_id"})})
 * @ORM\Entity
 */
class ShippingCostsExceptions
{
    /**
     * @var int
     *
     * @ORM\Column(name="shcx_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $shcxId;

    /**
     * @var string
     *
     * @ORM\Column(name="shcx_cost", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $shcxCost;

    /**
     * @var \Selling
     *
     * @ORM\ManyToOne(targetEntity="Selling")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shcx_selling_id", referencedColumnName="sll_id")
     * })
     */
    private $shcxSelling;

    /**
     * @var \Countries
     *
     * @ORM\ManyToOne(targetEntity="Countries")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shcx_country_id", referencedColumnName="ctr_id")
     * })
     */
    private $shcxCountry;

    public function getShcxId(): ?int
    {
        return $this->shcxId;
    }

    public function getShcxCost(): ?string
    {
        return $this->shcxCost;
    }

    public function setShcxCost(string $shcxCost): self
    {
        $this->shcxCost = $shcxCost;

        return $this;
    }

    public function getShcxSelling(): ?Selling
    {
        return $this->shcxSelling;
    }

    public function setShcxSelling(?Selling $shcxSelling): self
    {
        $this->shcxSelling = $shcxSelling;

        return $this;
    }

    public function getShcxCountry(): ?Countries
    {
        return $this->shcxCountry;
    }

    public function setShcxCountry(?Countries $shcxCountry): self
    {
        $this->shcxCountry = $shcxCountry;

        return $this;
    }


}
