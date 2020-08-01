<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Selling
 *
 * @ORM\Table(name="selling", indexes={@ORM\Index(name="sll_product_id", columns={"sll_product_id"}), @ORM\Index(name="sll_seller_id", columns={"sll_seller_id"})})
 * @ORM\Entity
 */
class Selling
{
    /**
     * @var int
     *
     * @ORM\Column(name="sll_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $sllId;

    /**
     * @var int
     *
     * @ORM\Column(name="sll_quantity", type="integer", nullable=false, options={"unsigned"=true})
     */
    private $sllQuantity;

    /**
     * @var string
     *
     * @ORM\Column(name="sll_mailer_co", type="string", length=80, nullable=false)
     */
    private $sllMailerCo;

    /**
     * @var \Products
     *
     * @ORM\ManyToOne(targetEntity="Products")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="sll_product_id", referencedColumnName="prod_id")
     * })
     */
    private $sllProduct;

    /**
     * @var \Sellers
     *
     * @ORM\ManyToOne(targetEntity="Sellers")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="sll_seller_id", referencedColumnName="sel_id")
     * })
     */
    private $sllSeller;

    public function getSllId(): ?int
    {
        return $this->sllId;
    }

    public function getSllQuantity(): ?int
    {
        return $this->sllQuantity;
    }

    public function setSllQuantity(int $sllQuantity): self
    {
        $this->sllQuantity = $sllQuantity;

        return $this;
    }

    public function getSllMailerCo(): ?string
    {
        return $this->sllMailerCo;
    }

    public function setSllMailerCo(string $sllMailerCo): self
    {
        $this->sllMailerCo = $sllMailerCo;

        return $this;
    }

    public function getSllProduct(): ?Products
    {
        return $this->sllProduct;
    }

    public function setSllProduct(?Products $sllProduct): self
    {
        $this->sllProduct = $sllProduct;

        return $this;
    }

    public function getSllSeller(): ?Sellers
    {
        return $this->sllSeller;
    }

    public function setSllSeller(?Sellers $sllSeller): self
    {
        $this->sllSeller = $sllSeller;

        return $this;
    }


}
