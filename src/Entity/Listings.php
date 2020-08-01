<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Listings
 *
 * @ORM\Table(name="listings", indexes={@ORM\Index(name="lis_selling_id", columns={"lis_selling_id"}), @ORM\Index(name="lis_currency_id", columns={"lis_currency_id"})})
 * @ORM\Entity
 */
class Listings
{
    /**
     * @var int
     *
     * @ORM\Column(name="lis_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $lisId;

    /**
     * @var string
     *
     * @ORM\Column(name="lis_price", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $lisPrice;

    /**
     * @var string
     *
     * @ORM\Column(name="lis_fee_eur", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $lisFeeEur;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="lis_from", type="date", nullable=false)
     */
    private $lisFrom;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="lis_to", type="date", nullable=false)
     */
    private $lisTo;

    /**
     * @var bool
     *
     * @ORM\Column(name="lis_watching", type="boolean", nullable=false)
     */
    private $lisWatching = '0';

    /**
     * @var bool
     *
     * @ORM\Column(name="lis_is_auction", type="boolean", nullable=false)
     */
    private $lisIsAuction = '0';

    /**
     * @var \Currencies
     *
     * @ORM\ManyToOne(targetEntity="Currencies")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="lis_currency_id", referencedColumnName="cur_id")
     * })
     */
    private $lisCurrency;

    /**
     * @var \Selling
     *
     * @ORM\ManyToOne(targetEntity="Selling")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="lis_selling_id", referencedColumnName="sll_id")
     * })
     */
    private $lisSelling;

    public function getLisId(): ?string
    {
        return $this->lisId;
    }

    public function getLisPrice(): ?string
    {
        return $this->lisPrice;
    }

    public function setLisPrice(string $lisPrice): self
    {
        $this->lisPrice = $lisPrice;

        return $this;
    }

    public function getLisFeeEur(): ?string
    {
        return $this->lisFeeEur;
    }

    public function setLisFeeEur(string $lisFeeEur): self
    {
        $this->lisFeeEur = $lisFeeEur;

        return $this;
    }

    public function getLisFrom(): ?\DateTimeInterface
    {
        return $this->lisFrom;
    }

    public function setLisFrom(\DateTimeInterface $lisFrom): self
    {
        $this->lisFrom = $lisFrom;

        return $this;
    }

    public function getLisTo(): ?\DateTimeInterface
    {
        return $this->lisTo;
    }

    public function setLisTo(\DateTimeInterface $lisTo): self
    {
        $this->lisTo = $lisTo;

        return $this;
    }

    public function getLisWatching(): ?bool
    {
        return $this->lisWatching;
    }

    public function setLisWatching(bool $lisWatching): self
    {
        $this->lisWatching = $lisWatching;

        return $this;
    }

    public function getLisIsAuction(): ?bool
    {
        return $this->lisIsAuction;
    }

    public function setLisIsAuction(bool $lisIsAuction): self
    {
        $this->lisIsAuction = $lisIsAuction;

        return $this;
    }

    public function getLisCurrency(): ?Currencies
    {
        return $this->lisCurrency;
    }

    public function setLisCurrency(?Currencies $lisCurrency): self
    {
        $this->lisCurrency = $lisCurrency;

        return $this;
    }

    public function getLisSelling(): ?Selling
    {
        return $this->lisSelling;
    }

    public function setLisSelling(?Selling $lisSelling): self
    {
        $this->lisSelling = $lisSelling;

        return $this;
    }


}
