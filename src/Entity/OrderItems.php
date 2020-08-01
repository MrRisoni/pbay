<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OrderItems
 *
 * @ORM\Table(name="order_items", indexes={@ORM\Index(name="itm_order_id", columns={"itm_order_id"}), @ORM\Index(name="itm_product_id", columns={"itm_product_id"}), @ORM\Index(name="itm_currency_id", columns={"itm_currency_id"}), @ORM\Index(name="itm_status_id", columns={"itm_status_id"}), @ORM\Index(name="itm_seller_id", columns={"itm_seller_id"})})
 * @ORM\Entity
 */
class OrderItems
{
    /**
     * @var int
     *
     * @ORM\Column(name="itm_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $itmId;

    /**
     * @var bool
     *
     * @ORM\Column(name="itm_quantity", type="boolean", nullable=false)
     */
    private $itmQuantity;

    /**
     * @var string
     *
     * @ORM\Column(name="itm_tracking_nums", type="string", length=225, nullable=false)
     */
    private $itmTrackingNums;

    /**
     * @var string
     *
     * @ORM\Column(name="itm_total", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $itmTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="itm_goods_total", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $itmGoodsTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="itm_ship_total", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $itmShipTotal;

    /**
     * @var bool
     *
     * @ORM\Column(name="itm_void", type="boolean", nullable=false)
     */
    private $itmVoid = '0';

    /**
     * @var \Currencies
     *
     * @ORM\ManyToOne(targetEntity="Currencies")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itm_currency_id", referencedColumnName="cur_id")
     * })
     */
    private $itmCurrency;

    /**
     * @var \Orders
     *
     * @ORM\ManyToOne(targetEntity="Orders")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itm_order_id", referencedColumnName="ord_id")
     * })
     */
    private $itmOrder;

    /**
     * @var \Selling
     *
     * @ORM\ManyToOne(targetEntity="Selling")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itm_product_id", referencedColumnName="sll_id")
     * })
     */
    private $itmProduct;

    /**
     * @var \Sellers
     *
     * @ORM\ManyToOne(targetEntity="Sellers")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itm_seller_id", referencedColumnName="sel_id")
     * })
     */
    private $itmSeller;

    /**
     * @var \OrderStatuses
     *
     * @ORM\ManyToOne(targetEntity="OrderStatuses")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="itm_status_id", referencedColumnName="stat_id")
     * })
     */
    private $itmStatus;

    public function getItmId(): ?string
    {
        return $this->itmId;
    }

    public function getItmQuantity(): ?bool
    {
        return $this->itmQuantity;
    }

    public function setItmQuantity(bool $itmQuantity): self
    {
        $this->itmQuantity = $itmQuantity;

        return $this;
    }

    public function getItmTrackingNums(): ?string
    {
        return $this->itmTrackingNums;
    }

    public function setItmTrackingNums(string $itmTrackingNums): self
    {
        $this->itmTrackingNums = $itmTrackingNums;

        return $this;
    }

    public function getItmTotal(): ?string
    {
        return $this->itmTotal;
    }

    public function setItmTotal(string $itmTotal): self
    {
        $this->itmTotal = $itmTotal;

        return $this;
    }

    public function getItmGoodsTotal(): ?string
    {
        return $this->itmGoodsTotal;
    }

    public function setItmGoodsTotal(string $itmGoodsTotal): self
    {
        $this->itmGoodsTotal = $itmGoodsTotal;

        return $this;
    }

    public function getItmShipTotal(): ?string
    {
        return $this->itmShipTotal;
    }

    public function setItmShipTotal(string $itmShipTotal): self
    {
        $this->itmShipTotal = $itmShipTotal;

        return $this;
    }

    public function getItmVoid(): ?bool
    {
        return $this->itmVoid;
    }

    public function setItmVoid(bool $itmVoid): self
    {
        $this->itmVoid = $itmVoid;

        return $this;
    }

    public function getItmCurrency(): ?Currencies
    {
        return $this->itmCurrency;
    }

    public function setItmCurrency(?Currencies $itmCurrency): self
    {
        $this->itmCurrency = $itmCurrency;

        return $this;
    }

    public function getItmOrder(): ?Orders
    {
        return $this->itmOrder;
    }

    public function setItmOrder(?Orders $itmOrder): self
    {
        $this->itmOrder = $itmOrder;

        return $this;
    }

    public function getItmProduct(): ?Selling
    {
        return $this->itmProduct;
    }

    public function setItmProduct(?Selling $itmProduct): self
    {
        $this->itmProduct = $itmProduct;

        return $this;
    }

    public function getItmSeller(): ?Sellers
    {
        return $this->itmSeller;
    }

    public function setItmSeller(?Sellers $itmSeller): self
    {
        $this->itmSeller = $itmSeller;

        return $this;
    }

    public function getItmStatus(): ?OrderStatuses
    {
        return $this->itmStatus;
    }

    public function setItmStatus(?OrderStatuses $itmStatus): self
    {
        $this->itmStatus = $itmStatus;

        return $this;
    }


}
