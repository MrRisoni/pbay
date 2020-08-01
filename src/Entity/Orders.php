<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Orders
 *
 * @ORM\Table(name="orders", indexes={@ORM\Index(name="ord_currency", columns={"ord_currency_id"}), @ORM\Index(name="ord_paymethod_id", columns={"ord_paymethod_id"}), @ORM\Index(name="ord_shipaddress_id", columns={"ord_shipaddress_id"}), @ORM\Index(name="ord_user_id", columns={"ord_user_id"}), @ORM\Index(name="ord_billaddress_id", columns={"ord_billaddress_id"})})
 * @ORM\Entity
 */
class Orders
{
    /**
     * @var int
     *
     * @ORM\Column(name="ord_id", type="bigint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ordId;

    /**
     * @var string
     *
     * @ORM\Column(name="ord_bank_transaction_id", type="string", length=45, nullable=false)
     */
    private $ordBankTransactionId;

    /**
     * @var string
     *
     * @ORM\Column(name="ord_total", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $ordTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="ord_goods_total", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $ordGoodsTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="ord_ship_total", type="decimal", precision=10, scale=2, nullable=false)
     */
    private $ordShipTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="ord_fee", type="decimal", precision=5, scale=2, nullable=false)
     */
    private $ordFee;

    /**
     * @var string
     *
     * @ORM\Column(name="ord_rate", type="decimal", precision=5, scale=2, nullable=false)
     */
    private $ordRate;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="ord_created", type="datetime", nullable=false)
     */
    private $ordCreated;

    /**
     * @var bool
     *
     * @ORM\Column(name="ord_success", type="boolean", nullable=false)
     */
    private $ordSuccess = '0';

    /**
     * @var bool
     *
     * @ORM\Column(name="ord_void", type="boolean", nullable=false)
     */
    private $ordVoid = '0';

    /**
     * @var \Currencies
     *
     * @ORM\ManyToOne(targetEntity="Currencies")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ord_currency_id", referencedColumnName="cur_id")
     * })
     */
    private $ordCurrency;

    /**
     * @var \Users
     *
     * @ORM\ManyToOne(targetEntity="Users")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ord_user_id", referencedColumnName="id")
     * })
     */
    private $ordUser;

    /**
     * @var \ShippingAddresses
     *
     * @ORM\ManyToOne(targetEntity="ShippingAddresses")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ord_shipaddress_id", referencedColumnName="shp_id")
     * })
     */
    private $ordShipaddress;

    /**
     * @var \BillingAddresses
     *
     * @ORM\ManyToOne(targetEntity="BillingAddresses")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ord_billaddress_id", referencedColumnName="bla_id")
     * })
     */
    private $ordBilladdress;

    /**
     * @var \Paymethods
     *
     * @ORM\ManyToOne(targetEntity="Paymethods")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ord_paymethod_id", referencedColumnName="pm_id")
     * })
     */
    private $ordPaymethod;

    public function getOrdId(): ?string
    {
        return $this->ordId;
    }

    public function getOrdBankTransactionId(): ?string
    {
        return $this->ordBankTransactionId;
    }

    public function setOrdBankTransactionId(string $ordBankTransactionId): self
    {
        $this->ordBankTransactionId = $ordBankTransactionId;

        return $this;
    }

    public function getOrdTotal(): ?string
    {
        return $this->ordTotal;
    }

    public function setOrdTotal(string $ordTotal): self
    {
        $this->ordTotal = $ordTotal;

        return $this;
    }

    public function getOrdGoodsTotal(): ?string
    {
        return $this->ordGoodsTotal;
    }

    public function setOrdGoodsTotal(string $ordGoodsTotal): self
    {
        $this->ordGoodsTotal = $ordGoodsTotal;

        return $this;
    }

    public function getOrdShipTotal(): ?string
    {
        return $this->ordShipTotal;
    }

    public function setOrdShipTotal(string $ordShipTotal): self
    {
        $this->ordShipTotal = $ordShipTotal;

        return $this;
    }

    public function getOrdFee(): ?string
    {
        return $this->ordFee;
    }

    public function setOrdFee(string $ordFee): self
    {
        $this->ordFee = $ordFee;

        return $this;
    }

    public function getOrdRate(): ?string
    {
        return $this->ordRate;
    }

    public function setOrdRate(string $ordRate): self
    {
        $this->ordRate = $ordRate;

        return $this;
    }

    public function getOrdCreated(): ?\DateTimeInterface
    {
        return $this->ordCreated;
    }

    public function setOrdCreated(\DateTimeInterface $ordCreated): self
    {
        $this->ordCreated = $ordCreated;

        return $this;
    }

    public function getOrdSuccess(): ?bool
    {
        return $this->ordSuccess;
    }

    public function setOrdSuccess(bool $ordSuccess): self
    {
        $this->ordSuccess = $ordSuccess;

        return $this;
    }

    public function getOrdVoid(): ?bool
    {
        return $this->ordVoid;
    }

    public function setOrdVoid(bool $ordVoid): self
    {
        $this->ordVoid = $ordVoid;

        return $this;
    }

    public function getOrdCurrency(): ?Currencies
    {
        return $this->ordCurrency;
    }

    public function setOrdCurrency(?Currencies $ordCurrency): self
    {
        $this->ordCurrency = $ordCurrency;

        return $this;
    }

    public function getOrdUser(): ?Users
    {
        return $this->ordUser;
    }

    public function setOrdUser(?Users $ordUser): self
    {
        $this->ordUser = $ordUser;

        return $this;
    }

    public function getOrdShipaddress(): ?ShippingAddresses
    {
        return $this->ordShipaddress;
    }

    public function setOrdShipaddress(?ShippingAddresses $ordShipaddress): self
    {
        $this->ordShipaddress = $ordShipaddress;

        return $this;
    }

    public function getOrdBilladdress(): ?BillingAddresses
    {
        return $this->ordBilladdress;
    }

    public function setOrdBilladdress(?BillingAddresses $ordBilladdress): self
    {
        $this->ordBilladdress = $ordBilladdress;

        return $this;
    }

    public function getOrdPaymethod(): ?Paymethods
    {
        return $this->ordPaymethod;
    }

    public function setOrdPaymethod(?Paymethods $ordPaymethod): self
    {
        $this->ordPaymethod = $ordPaymethod;

        return $this;
    }


}
