<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OrderItemTrackHistory
 *
 * @ORM\Table(name="order_item_track_history", indexes={@ORM\Index(name="itmh_item_id", columns={"itmh_item_id"}), @ORM\Index(name="itmh_status_id", columns={"itmh_status_id"})})
 * @ORM\Entity
 */
class OrderItemTrackHistory
{
    /**
     * @var int
     *
     * @ORM\Column(name="itmh_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $itmhId;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="itmh_created_at", type="datetime", nullable=false)
     */
    private $itmhCreatedAt;

    /**
     * @var \OrderItems
     *
     * @ORM\ManyToOne(targetEntity="OrderItems")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itmh_item_id", referencedColumnName="itm_id")
     * })
     */
    private $itmhItem;

    /**
     * @var \OrderStatuses
     *
     * @ORM\ManyToOne(targetEntity="OrderStatuses")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itmh_status_id", referencedColumnName="stat_id")
     * })
     */
    private $itmhStatus;

    public function getItmhId(): ?string
    {
        return $this->itmhId;
    }

    public function getItmhCreatedAt(): ?\DateTimeInterface
    {
        return $this->itmhCreatedAt;
    }

    public function setItmhCreatedAt(\DateTimeInterface $itmhCreatedAt): self
    {
        $this->itmhCreatedAt = $itmhCreatedAt;

        return $this;
    }

    public function getItmhItem(): ?OrderItems
    {
        return $this->itmhItem;
    }

    public function setItmhItem(?OrderItems $itmhItem): self
    {
        $this->itmhItem = $itmhItem;

        return $this;
    }

    public function getItmhStatus(): ?OrderStatuses
    {
        return $this->itmhStatus;
    }

    public function setItmhStatus(?OrderStatuses $itmhStatus): self
    {
        $this->itmhStatus = $itmhStatus;

        return $this;
    }


}
