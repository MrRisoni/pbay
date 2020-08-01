<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * BillingAddresses
 *
 * @ORM\Table(name="billing_addresses", indexes={@ORM\Index(name="shp_user_id", columns={"bla_user_id"}), @ORM\Index(name="shp_country_id", columns={"bla_country_id"})})
 * @ORM\Entity
 */
class BillingAddresses
{
    /**
     * @var int
     *
     * @ORM\Column(name="bla_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $blaId;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_city", type="string", length=55, nullable=false)
     */
    private $blaCity;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_region", type="string", length=55, nullable=false)
     */
    private $blaRegion;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_street", type="string", length=55, nullable=false)
     */
    private $blaStreet;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_street_no", type="string", length=8, nullable=false)
     */
    private $blaStreetNo;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_code", type="string", length=9, nullable=false)
     */
    private $blaCode;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_surname", type="string", length=55, nullable=false)
     */
    private $blaSurname;

    /**
     * @var string
     *
     * @ORM\Column(name="bla_name", type="string", length=55, nullable=false)
     */
    private $blaName;

    /**
     * @var \Countries
     *
     * @ORM\ManyToOne(targetEntity="Countries")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="bla_country_id", referencedColumnName="ctr_id")
     * })
     */
    private $blaCountry;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="bla_user_id", referencedColumnName="id")
     * })
     */
    private $blaUser;

    public function getBlaId(): ?string
    {
        return $this->blaId;
    }

    public function getBlaCity(): ?string
    {
        return $this->blaCity;
    }

    public function setBlaCity(string $blaCity): self
    {
        $this->blaCity = $blaCity;

        return $this;
    }

    public function getBlaRegion(): ?string
    {
        return $this->blaRegion;
    }

    public function setBlaRegion(string $blaRegion): self
    {
        $this->blaRegion = $blaRegion;

        return $this;
    }

    public function getBlaStreet(): ?string
    {
        return $this->blaStreet;
    }

    public function setBlaStreet(string $blaStreet): self
    {
        $this->blaStreet = $blaStreet;

        return $this;
    }

    public function getBlaStreetNo(): ?string
    {
        return $this->blaStreetNo;
    }

    public function setBlaStreetNo(string $blaStreetNo): self
    {
        $this->blaStreetNo = $blaStreetNo;

        return $this;
    }

    public function getBlaCode(): ?string
    {
        return $this->blaCode;
    }

    public function setBlaCode(string $blaCode): self
    {
        $this->blaCode = $blaCode;

        return $this;
    }

    public function getBlaSurname(): ?string
    {
        return $this->blaSurname;
    }

    public function setBlaSurname(string $blaSurname): self
    {
        $this->blaSurname = $blaSurname;

        return $this;
    }

    public function getBlaName(): ?string
    {
        return $this->blaName;
    }

    public function setBlaName(string $blaName): self
    {
        $this->blaName = $blaName;

        return $this;
    }

    public function getBlaCountry(): ?Countries
    {
        return $this->blaCountry;
    }

    public function setBlaCountry(?Countries $blaCountry): self
    {
        $this->blaCountry = $blaCountry;

        return $this;
    }

    public function getBlaUser(): ?Users
    {
        return $this->blaUser;
    }

    public function setBlaUser(?Users $blaUser): self
    {
        $this->blaUser = $blaUser;

        return $this;
    }


}
