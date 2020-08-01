<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Countries
 *
 * @ORM\Table(name="countries", uniqueConstraints={@ORM\UniqueConstraint(name="ctr_code", columns={"ctr_code"}), @ORM\UniqueConstraint(name="ctr_title", columns={"ctr_title"})}, indexes={@ORM\Index(name="ctr_continent_id", columns={"ctr_continent_id"})})
 * @ORM\Entity
 */
class Countries
{
    /**
     * @var int
     *
     * @ORM\Column(name="ctr_id", type="smallint", nullable=false, options={"unsigned"=true})
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ctrId;

    /**
     * @var string
     *
     * @ORM\Column(name="ctr_title", type="string", length=45, nullable=false)
     */
    private $ctrTitle;

    /**
     * @var string
     *
     * @ORM\Column(name="ctr_code", type="string", length=2, nullable=false)
     */
    private $ctrCode;

    /**
     * @var \Continents
     *
     * @ORM\ManyToOne(targetEntity="Continents")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ctr_continent_id", referencedColumnName="con_id")
     * })
     */
    private $ctrContinent;

    public function getCtrId(): ?int
    {
        return $this->ctrId;
    }

    public function getCtrTitle(): ?string
    {
        return $this->ctrTitle;
    }

    public function setCtrTitle(string $ctrTitle): self
    {
        $this->ctrTitle = $ctrTitle;

        return $this;
    }

    public function getCtrCode(): ?string
    {
        return $this->ctrCode;
    }

    public function setCtrCode(string $ctrCode): self
    {
        $this->ctrCode = $ctrCode;

        return $this;
    }

    public function getCtrContinent(): ?Continents
    {
        return $this->ctrContinent;
    }

    public function setCtrContinent(?Continents $ctrContinent): self
    {
        $this->ctrContinent = $ctrContinent;

        return $this;
    }


}
