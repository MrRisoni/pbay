<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Timetablings
 *
 * @ORM\Table(name="timetablings", indexes={@ORM\Index(name="index_timetablings_on_days_id", columns={"days_id"}), @ORM\Index(name="index_timetablings_on_ending_hour_id", columns={"ending_hour_id"}), @ORM\Index(name="index_timetablings_on_starting_hour_id", columns={"starting_hour_id"}), @ORM\Index(name="index_timetablings_on_studies_id", columns={"studies_id"})})
 * @ORM\Entity
 */
class Timetablings
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="bigint", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \Hours
     *
     * @ORM\ManyToOne(targetEntity="Hours")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ending_hour_id", referencedColumnName="id")
     * })
     */
    private $endingHour;

    /**
     * @var \Days
     *
     * @ORM\ManyToOne(targetEntity="Days")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="days_id", referencedColumnName="id")
     * })
     */
    private $days;

    /**
     * @var \Hours
     *
     * @ORM\ManyToOne(targetEntity="Hours")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="starting_hour_id", referencedColumnName="id")
     * })
     */
    private $startingHour;

    /**
     * @var \Studies
     *
     * @ORM\ManyToOne(targetEntity="Studies")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="studies_id", referencedColumnName="id")
     * })
     */
    private $studies;

    /**
     * @ORM\ManyToOne(targetEntity=Days::class, inversedBy="timetablings")
     * @ORM\JoinColumn(nullable=false)
     */
    private $tag;

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getEndingHour(): ?Hours
    {
        return $this->endingHour;
    }

    public function setEndingHour(?Hours $endingHour): self
    {
        $this->endingHour = $endingHour;

        return $this;
    }

    public function getDays(): ?Days
    {
        return $this->days;
    }

    public function setDays(?Days $days): self
    {
        $this->days = $days;

        return $this;
    }

    public function getStartingHour(): ?Hours
    {
        return $this->startingHour;
    }

    public function setStartingHour(?Hours $startingHour): self
    {
        $this->startingHour = $startingHour;

        return $this;
    }

    public function getStudies(): ?Studies
    {
        return $this->studies;
    }

    public function setStudies(?Studies $studies): self
    {
        $this->studies = $studies;

        return $this;
    }

    public function getTag(): ?Days
    {
        return $this->tag;
    }

    public function setTag(?Days $tag): self
    {
        $this->tag = $tag;

        return $this;
    }


}
