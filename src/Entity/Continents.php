<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Continents
 *
 * @ORM\Table(name="continents", uniqueConstraints={@ORM\UniqueConstraint(name="con_title", columns={"con_code"}), @ORM\UniqueConstraint(name="con_code", columns={"con_code"})})
 * @ORM\Entity
 */
class Continents
{
    /**
     * @var bool
     *
     * @ORM\Column(name="con_id", type="boolean", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $conId;

    /**
     * @var string
     *
     * @ORM\Column(name="con_code", type="string", length=3, nullable=false)
     */
    private $conCode;

    /**
     * @var string
     *
     * @ORM\Column(name="con_title", type="string", length=35, nullable=false)
     */
    private $conTitle;

    public function getConId(): ?bool
    {
        return $this->conId;
    }

    public function getConCode(): ?string
    {
        return $this->conCode;
    }

    public function setConCode(string $conCode): self
    {
        $this->conCode = $conCode;

        return $this;
    }

    public function getConTitle(): ?string
    {
        return $this->conTitle;
    }

    public function setConTitle(string $conTitle): self
    {
        $this->conTitle = $conTitle;

        return $this;
    }


}
