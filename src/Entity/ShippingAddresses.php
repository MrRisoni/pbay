<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ShippingAddresses
 *
 * @ORM\Table(name="shipping_addresses", indexes={@ORM\Index(name="shp_user_id", columns={"shp_user_id"}), @ORM\Index(name="shp_country_id", columns={"shp_country_id"})})
 * @ORM\Entity
 */
class ShippingAddresses
{
    /**
     * @var int
     *
     * @ORM\Column(name="shp_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $shpId;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_city", type="string", length=55, nullable=false)
     */
    private $shpCity;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_region", type="string", length=55, nullable=false)
     */
    private $shpRegion;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_street", type="string", length=55, nullable=false)
     */
    private $shpStreet;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_street_no", type="string", length=8, nullable=false)
     */
    private $shpStreetNo;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_code", type="string", length=9, nullable=false)
     */
    private $shpCode;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_surname", type="string", length=55, nullable=false)
     */
    private $shpSurname;

    /**
     * @var string
     *
     * @ORM\Column(name="shp_name", type="string", length=55, nullable=false)
     */
    private $shpName;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shp_user_id", referencedColumnName="id")
     * })
     */
    private $shpUser;

    /**
     * @var \Countries
     *
     * @ORM\ManyToOne(targetEntity="Countries")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="shp_country_id", referencedColumnName="ctr_id")
     * })
     */
    private $shpCountry;

    public function getShpId(): ?string
    {
        return $this->shpId;
    }

    public function getShpCity(): ?string
    {
        return $this->shpCity;
    }

    public function setShpCity(string $shpCity): self
    {
        $this->shpCity = $shpCity;

        return $this;
    }

    public function getShpRegion(): ?string
    {
        return $this->shpRegion;
    }

    public function setShpRegion(string $shpRegion): self
    {
        $this->shpRegion = $shpRegion;

        return $this;
    }

    public function getShpStreet(): ?string
    {
        return $this->shpStreet;
    }

    public function setShpStreet(string $shpStreet): self
    {
        $this->shpStreet = $shpStreet;

        return $this;
    }

    public function getShpStreetNo(): ?string
    {
        return $this->shpStreetNo;
    }

    public function setShpStreetNo(string $shpStreetNo): self
    {
        $this->shpStreetNo = $shpStreetNo;

        return $this;
    }

    public function getShpCode(): ?string
    {
        return $this->shpCode;
    }

    public function setShpCode(string $shpCode): self
    {
        $this->shpCode = $shpCode;

        return $this;
    }

    public function getShpSurname(): ?string
    {
        return $this->shpSurname;
    }

    public function setShpSurname(string $shpSurname): self
    {
        $this->shpSurname = $shpSurname;

        return $this;
    }

    public function getShpName(): ?string
    {
        return $this->shpName;
    }

    public function setShpName(string $shpName): self
    {
        $this->shpName = $shpName;

        return $this;
    }

    public function getShpUser(): ?Users
    {
        return $this->shpUser;
    }

    public function setShpUser(?Users $shpUser): self
    {
        $this->shpUser = $shpUser;

        return $this;
    }

    public function getShpCountry(): ?Countries
    {
        return $this->shpCountry;
    }

    public function setShpCountry(?Countries $shpCountry): self
    {
        $this->shpCountry = $shpCountry;

        return $this;
    }


}
