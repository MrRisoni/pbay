<?php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


class KanbanController extends AbstractController
{
	 /**
+      * @Route("/kanban/index")
+      */
    public function index(): Response
    {
        $ProjectsStagesRepository = $this->getDoctrine()->getRepository(\App\Entity\ProjectStages::class);

       return $this->render('kanban/index.html.twig', [
            'stages' => $ProjectsStagesRepository->findAll()]);
    }
}