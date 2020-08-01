<?php

namespace ContainerTnAyOPC;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getKanbanControllerService extends App_KernelDevDebugContainer
{
    /**
     * Gets the public 'App\Controller\KanbanController' shared autowired service.
     *
     * @return \App\Controller\KanbanController
     */
    public static function do($container, $lazyLoad = true)
    {
        include_once \dirname(__DIR__, 4).'/vendor/symfony/framework-bundle/Controller/AbstractController.php';
        include_once \dirname(__DIR__, 4).'/src/Controller/KanbanController.php';

        $container->services['App\\Controller\\KanbanController'] = $instance = new \App\Controller\KanbanController();

        $instance->setContainer(($container->privates['.service_locator.g9CqTPp'] ?? $container->load('get_ServiceLocator_G9CqTPpService'))->withContext('App\\Controller\\KanbanController', $container));

        return $instance;
    }
}