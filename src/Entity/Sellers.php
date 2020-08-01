<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Sellers
 *
 * @ORM\Table(name="sellers", indexes={@ORM\Index(name="sel_country_id", columns={"sel_country_id"}), @ORM\Index(name="seller_usr_id", columns={"seller_usr_id"})})
 * @ORM\Entity
 */
class Sellers
{
    /**
     * @var int
     *
     * @ORM\Column(name="sel_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $selId;

    /**
     * @var string
     *
     * @ORM\Column(name="sel_title", type="string", length=125, nullable=false)
     */
    private $selTitle;

    /**
     * @var string
     *
     * @ORM\Column(name="sel_ssn", type="string", length=60, nullable=false)
     */
    private $selSsn;

    /**
     * @var string
     *
     * @ORM\Column(name="sel_stars_avg", type="decimal", precision=3, scale=2, nullable=false)
     */
    private $selStarsAvg;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="seller_usr_id", referencedColumnName="id")
     * })
     */
    private $sellerUsr;

    /**
     * @var \Countries
     *
     * @ORM\ManyToOne(targetEntity="Countries")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="sel_country_id", referencedColumnName="ctr_id")
     * })
     */
    private $selCountry;

    public function getSelId(): ?int
    {
        return $this->selId;
    }

    public function getSelTitle(): ?string
    {
        return $this->selTitle;
    }

    public function setSelTitle(string $selTitle): self
    {
        $this->selTitle = $selTitle;

        return $this;
    }

    public function getSelSsn(): ?string
    {
        return $this->selSsn;
    }

    public function setSelSsn(string $selSsn): self
    {
        $this->selSsn = $selSsn;

        return $this;
    }

    public function getSelStarsAvg(): ?string
    {
        return $this->selStarsAvg;
    }

    public function setSelStarsAvg(string $selStarsAvg): self
    {
        $this->selStarsAvg = $selStarsAvg;

        return $this;
    }

    public function getSellerUsr(): ?Users
    {
        return $this->sellerUsr;
    }

    public function setSellerUsr(?Users $sellerUsr): self
    {
        $this->sellerUsr = $sellerUsr;

        return $this;
    }

    public function getSelCountry(): ?Countries
    {
        return $this->selCountry;
    }

    public function setSelCountry(?Countries $selCountry): self
    {
        $this->selCountry = $selCountry;

        return $this;
    }


}
