<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Currencies
 *
 * @ORM\Table(name="currencies", uniqueConstraints={@ORM\UniqueConstraint(name="cur_title", columns={"cur_code"})})
 * @ORM\Entity
 */
class Currencies
{
    /**
     * @var bool
     *
     * @ORM\Column(name="cur_id", type="boolean", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $curId;

    /**
     * @var string
     *
     * @ORM\Column(name="cur_code", type="string", length=3, nullable=false)
     */
    private $curCode;

    /**
     * @var string
     *
     * @ORM\Column(name="cur_rate", type="decimal", precision=5, scale=2, nullable=false)
     */
    private $curRate;

    public function getCurId(): ?bool
    {
        return $this->curId;
    }

    public function getCurCode(): ?string
    {
        return $this->curCode;
    }

    public function setCurCode(string $curCode): self
    {
        $this->curCode = $curCode;

        return $this;
    }

    public function getCurRate(): ?string
    {
        return $this->curRate;
    }

    public function setCurRate(string $curRate): self
    {
        $this->curRate = $curRate;

        return $this;
    }


}
