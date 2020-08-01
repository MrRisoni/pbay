<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reviews
 *
 * @ORM\Table(name="reviews", indexes={@ORM\Index(name="rev_usr_id", columns={"rev_usr_id"}), @ORM\Index(name="rev_ord_item_id", columns={"rev_ord_item_id"})})
 * @ORM\Entity
 */
class Reviews
{
    /**
     * @var int
     *
     * @ORM\Column(name="rev_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $revId;

    /**
     * @var string
     *
     * @ORM\Column(name="rev_comment", type="text", length=65535, nullable=false)
     */
    private $revComment;

    /**
     * @var string
     *
     * @ORM\Column(name="rev_star", type="decimal", precision=5, scale=2, nullable=false)
     */
    private $revStar;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="rev_created_at", type="datetime", nullable=false)
     */
    private $revCreatedAt;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="rev_usr_id", referencedColumnName="id")
     * })
     */
    private $revUsr;

    /**
     * @var \OrderItems
     *
     * @ORM\ManyToOne(targetEntity="OrderItems")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="rev_ord_item_id", referencedColumnName="itm_id")
     * })
     */
    private $revOrdItem;

    public function getRevId(): ?string
    {
        return $this->revId;
    }

    public function getRevComment(): ?string
    {
        return $this->revComment;
    }

    public function setRevComment(string $revComment): self
    {
        $this->revComment = $revComment;

        return $this;
    }

    public function getRevStar(): ?string
    {
        return $this->revStar;
    }

    public function setRevStar(string $revStar): self
    {
        $this->revStar = $revStar;

        return $this;
    }

    public function getRevCreatedAt(): ?\DateTimeInterface
    {
        return $this->revCreatedAt;
    }

    public function setRevCreatedAt(\DateTimeInterface $revCreatedAt): self
    {
        $this->revCreatedAt = $revCreatedAt;

        return $this;
    }

    public function getRevUsr(): ?Users
    {
        return $this->revUsr;
    }

    public function setRevUsr(?Users $revUsr): self
    {
        $this->revUsr = $revUsr;

        return $this;
    }

    public function getRevOrdItem(): ?OrderItems
    {
        return $this->revOrdItem;
    }

    public function setRevOrdItem(?OrderItems $revOrdItem): self
    {
        $this->revOrdItem = $revOrdItem;

        return $this;
    }


}
