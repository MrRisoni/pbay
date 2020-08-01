<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ListingWatching
 *
 * @ORM\Table(name="listing_watching", indexes={@ORM\Index(name="lwi_user_ud", columns={"lwi_user_ud"}), @ORM\Index(name="lwi_listing_id", columns={"lwi_listing_id"})})
 * @ORM\Entity
 */
class ListingWatching
{
    /**
     * @var int
     *
     * @ORM\Column(name="lwi_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $lwiId;

    /**
     * @var int
     *
     * @ORM\Column(name="lwi_user_ud", type="bigint", nullable=false, options={"unsigned"=true})
     */
    private $lwiUserUd;

    /**
     * @var int
     *
     * @ORM\Column(name="lwi_listing_id", type="bigint", nullable=false, options={"unsigned"=true})
     */
    private $lwiListingId;

    public function getLwiId(): ?int
    {
        return $this->lwiId;
    }

    public function getLwiUserUd(): ?string
    {
        return $this->lwiUserUd;
    }

    public function setLwiUserUd(string $lwiUserUd): self
    {
        $this->lwiUserUd = $lwiUserUd;

        return $this;
    }

    public function getLwiListingId(): ?string
    {
        return $this->lwiListingId;
    }

    public function setLwiListingId(string $lwiListingId): self
    {
        $this->lwiListingId = $lwiListingId;

        return $this;
    }


}
