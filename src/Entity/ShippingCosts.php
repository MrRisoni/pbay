<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ShippingCosts
 *
 * @ORM\Table(name="shipping_costs", indexes={@ORM\Index(name="shc_selling_id", columns={"shc_selling_id"}), @ORM\Index(name="shc_continent_id", columns={"shc_continent_id"})})
 * @ORM\Entity
 */
class ShippingCosts
{
    /**
     * @var int
     *
     * @ORM\Column(name="shc_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $shcId;

    /**
     * @var string
     *
     * @ORM\Column(name="shc_cost", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $shcCost;

    /**
     * @var \Continents
     *
     * @ORM\ManyToOne(targetEntity="Continents")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shc_continent_id", referencedColumnName="con_id")
     * })
     */
    private $shcContinent;

    /**
     * @var \Selling
     *
     * @ORM\ManyToOne(targetEntity="Selling")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shc_selling_id", referencedColumnName="sll_id")
     * })
     */
    private $shcSelling;

    public function getShcId(): ?int
    {
        return $this->shcId;
    }

    public function getShcCost(): ?string
    {
        return $this->shcCost;
    }

    public function setShcCost(string $shcCost): self
    {
        $this->shcCost = $shcCost;

        return $this;
    }

    public function getShcContinent(): ?Continents
    {
        return $this->shcContinent;
    }

    public function setShcContinent(?Continents $shcContinent): self
    {
        $this->shcContinent = $shcContinent;

        return $this;
    }

    public function getShcSelling(): ?Selling
    {
        return $this->shcSelling;
    }

    public function setShcSelling(?Selling $shcSelling): self
    {
        $this->shcSelling = $shcSelling;

        return $this;
    }


}
