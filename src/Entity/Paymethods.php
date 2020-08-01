<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Paymethods
 *
 * @ORM\Table(name="paymethods")
 * @ORM\Entity
 */
class Paymethods
{
    /**
     * @var bool
     *
     * @ORM\Column(name="pm_id", type="boolean", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $pmId;

    /**
     * @var string
     *
     * @ORM\Column(name="pm_title", type="string", length=25, nullable=false)
     */
    private $pmTitle;

    public function getPmId(): ?bool
    {
        return $this->pmId;
    }

    public function getPmTitle(): ?string
    {
        return $this->pmTitle;
    }

    public function setPmTitle(string $pmTitle): self
    {
        $this->pmTitle = $pmTitle;

        return $this;
    }


}
