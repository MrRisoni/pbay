<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ShippingCountryForbidden
 *
 * @ORM\Table(name="shipping_country_forbidden", uniqueConstraints={@ORM\UniqueConstraint(name="shf_selling_id_2", columns={"shf_selling_id", "shf_country_id"})}, indexes={@ORM\Index(name="shf_country_id", columns={"shf_country_id"}), @ORM\Index(name="shf_selling_id", columns={"shf_selling_id"})})
 * @ORM\Entity
 */
class ShippingCountryForbidden
{
    /**
     * @var int
     *
     * @ORM\Column(name="shf_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $shfId;

    /**
     * @var \Countries
     *
     * @ORM\ManyToOne(targetEntity="Countries")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shf_country_id", referencedColumnName="ctr_id")
     * })
     */
    private $shfCountry;

    /**
     * @var \Selling
     *
     * @ORM\ManyToOne(targetEntity="Selling")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shf_selling_id", referencedColumnName="sll_id")
     * })
     */
    private $shfSelling;

    public function getShfId(): ?int
    {
        return $this->shfId;
    }

    public function getShfCountry(): ?Countries
    {
        return $this->shfCountry;
    }

    public function setShfCountry(?Countries $shfCountry): self
    {
        $this->shfCountry = $shfCountry;

        return $this;
    }

    public function getShfSelling(): ?Selling
    {
        return $this->shfSelling;
    }

    public function setShfSelling(?Selling $shfSelling): self
    {
        $this->shfSelling = $shfSelling;

        return $this;
    }


}
