<?php

namespace App\Repository;

use App\Entity\ProjectStage;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method ProjectStage|null find($id, $lockMode = null, $lockVersion = null)
 * @method ProjectStage|null findOneBy(array $criteria, array $orderBy = null)
 * @method ProjectStage[]    findAll()
 * @method ProjectStage[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ProjectStageRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, ProjectStage::class);
    }

    // /**
    //  * @return ProjectStage[] Returns an array of ProjectStage objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('p.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?ProjectStage
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
