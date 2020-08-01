<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * OrderStatuses
 *
 * @ORM\Table(name="order_statuses", uniqueConstraints={@ORM\UniqueConstraint(name="stat_title", columns={"stat_title"})})
 * @ORM\Entity
 */
class OrderStatuses
{
    /**
     * @var bool
     *
     * @ORM\Column(name="stat_id", type="boolean", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $statId;

    /**
     * @var string
     *
     * @ORM\Column(name="stat_title", type="string", length=34, nullable=false)
     */
    private $statTitle;

    public function getStatId(): ?bool
    {
        return $this->statId;
    }

    public function getStatTitle(): ?string
    {
        return $this->statTitle;
    }

    public function setStatTitle(string $statTitle): self
    {
        $this->statTitle = $statTitle;

        return $this;
    }


}
