<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Biddings
 *
 * @ORM\Table(name="biddings", indexes={@ORM\Index(name="bid_user_id", columns={"bid_user_id"}), @ORM\Index(name="bid_currency_id", columns={"bid_currency_id"}), @ORM\Index(name="bid_listing_id", columns={"bid_listing_id"})})
 * @ORM\Entity
 */
class Biddings
{
    /**
     * @var int
     *
     * @ORM\Column(name="bid_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $bidId;

    /**
     * @var string
     *
     * @ORM\Column(name="bid_price", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $bidPrice;

    /**
     * @var string
     *
     * @ORM\Column(name="bid_price_eur", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $bidPriceEur;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="bid_created_at", type="datetime", nullable=false)
     */
    private $bidCreatedAt;

    /**
     * @var bool
     *
     * @ORM\Column(name="bid_active", type="boolean", nullable=false)
     */
    private $bidActive;

    /**
     * @var \Currencies
     *
     * @ORM\ManyToOne(targetEntity="Currencies")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="bid_currency_id", referencedColumnName="cur_id")
     * })
     */
    private $bidCurrency;

    /**
     * @var \Listings
     *
     * @ORM\ManyToOne(targetEntity="Listings")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="bid_listing_id", referencedColumnName="lis_id")
     * })
     */
    private $bidListing;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="bid_user_id", referencedColumnName="id")
     * })
     */
    private $bidUser;

    public function getBidId(): ?int
    {
        return $this->bidId;
    }

    public function getBidPrice(): ?string
    {
        return $this->bidPrice;
    }

    public function setBidPrice(string $bidPrice): self
    {
        $this->bidPrice = $bidPrice;

        return $this;
    }

    public function getBidPriceEur(): ?string
    {
        return $this->bidPriceEur;
    }

    public function setBidPriceEur(string $bidPriceEur): self
    {
        $this->bidPriceEur = $bidPriceEur;

        return $this;
    }

    public function getBidCreatedAt(): ?\DateTimeInterface
    {
        return $this->bidCreatedAt;
    }

    public function setBidCreatedAt(\DateTimeInterface $bidCreatedAt): self
    {
        $this->bidCreatedAt = $bidCreatedAt;

        return $this;
    }

    public function getBidActive(): ?bool
    {
        return $this->bidActive;
    }

    public function setBidActive(bool $bidActive): self
    {
        $this->bidActive = $bidActive;

        return $this;
    }

    public function getBidCurrency(): ?Currencies
    {
        return $this->bidCurrency;
    }

    public function setBidCurrency(?Currencies $bidCurrency): self
    {
        $this->bidCurrency = $bidCurrency;

        return $this;
    }

    public function getBidListing(): ?Listings
    {
        return $this->bidListing;
    }

    public function setBidListing(?Listings $bidListing): self
    {
        $this->bidListing = $bidListing;

        return $this;
    }

    public function getBidUser(): ?Users
    {
        return $this->bidUser;
    }

    public function setBidUser(?Users $bidUser): self
    {
        $this->bidUser = $bidUser;

        return $this;
    }


}
