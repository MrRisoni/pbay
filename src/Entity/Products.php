<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Products
 *
 * @ORM\Table(name="products", indexes={@ORM\Index(name="prod_category_id", columns={"prod_category_id"})})
 * @ORM\Entity
 */
class Products
{
    /**
     * @var int
     *
     * @ORM\Column(name="prod_id", type="integer", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $prodId;

    /**
     * @var string
     *
     * @ORM\Column(name="prod_title", type="string", length=255, nullable=false)
     */
    private $prodTitle;

    /**
     * @var string
     *
     * @ORM\Column(name="prod_other_title", type="string", length=80, nullable=false)
     */
    private $prodOtherTitle;

    /**
     * @var string
     *
     * @ORM\Column(name="prod_descr", type="text", length=65535, nullable=false)
     */
    private $prodDescr;

    /**
     * @var bool
     *
     * @ORM\Column(name="prod_preowned", type="boolean", nullable=false)
     */
    private $prodPreowned = '0';

    /**
     * @var \ProductsCategories
     *
     * @ORM\ManyToOne(targetEntity="ProductsCategories")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="prod_category_id", referencedColumnName="cat_id")
     * })
     */
    private $prodCategory;

    public function getProdId(): ?int
    {
        return $this->prodId;
    }

    public function getProdTitle(): ?string
    {
        return $this->prodTitle;
    }

    public function setProdTitle(string $prodTitle): self
    {
        $this->prodTitle = $prodTitle;

        return $this;
    }

    public function getProdOtherTitle(): ?string
    {
        return $this->prodOtherTitle;
    }

    public function setProdOtherTitle(string $prodOtherTitle): self
    {
        $this->prodOtherTitle = $prodOtherTitle;

        return $this;
    }

    public function getProdDescr(): ?string
    {
        return $this->prodDescr;
    }

    public function setProdDescr(string $prodDescr): self
    {
        $this->prodDescr = $prodDescr;

        return $this;
    }

    public function getProdPreowned(): ?bool
    {
        return $this->prodPreowned;
    }

    public function setProdPreowned(bool $prodPreowned): self
    {
        $this->prodPreowned = $prodPreowned;

        return $this;
    }

    public function getProdCategory(): ?ProductsCategories
    {
        return $this->prodCategory;
    }

    public function setProdCategory(?ProductsCategories $prodCategory): self
    {
        $this->prodCategory = $prodCategory;

        return $this;
    }


}
