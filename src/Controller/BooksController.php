<?php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


class BooksController extends AbstractController
{
	 /**
+      * @Route("/books/index")
+      */
    public function index(): Response
    {
        $BookRepository = $this->getDoctrine()->getRepository(\App\Entity\Books::class);

        return $this->render('wipbooks/index.html.twig', [
            'books' =>  $BookRepository->findAll()
        ]);
    }
}