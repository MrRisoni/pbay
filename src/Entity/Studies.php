<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Studies
 *
 * @ORM\Table(name="studies", uniqueConstraints={@ORM\UniqueConstraint(name="index_studies_on_title", columns={"title"})})
 * @ORM\Entity
 */
class Studies
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
     * @var string|null
     *
     * @ORM\Column(name="title", type="string", length=40, nullable=true)
     */
    private $title;

    /**
     * @var string|null
     *
     * @ORM\Column(name="css", type="string", length=7, nullable=true, options={"default"="#ffffff"})
     */
    private $css = '#ffffff';

    /**
     * @var string|null
     *
     * @ORM\Column(name="fore_css", type="string", length=7, nullable=true, options={"default"="#000"})
     */
    private $foreCss = '#000';

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getTitle(): ?string
    {
        return $this->title;
    }

    public function setTitle(?string $title): self
    {
        $this->title = $title;

        return $this;
    }

    public function getCss(): ?string
    {
        return $this->css;
    }

    public function setCss(?string $css): self
    {
        $this->css = $css;

        return $this;
    }

    public function getForeCss(): ?string
    {
        return $this->foreCss;
    }

    public function setForeCss(?string $foreCss): self
    {
        $this->foreCss = $foreCss;

        return $this;
    }


}
