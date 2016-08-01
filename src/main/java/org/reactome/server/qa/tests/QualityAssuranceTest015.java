package org.reactome.server.qa.tests;

import org.neo4j.ogm.model.Result;
import org.reactome.server.qa.annotations.QATest;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Florian Korninger <florian.korninger@ebi.ac.uk>
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest015 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "CatalystActivityWithoutPhysicalEntity";
    }

    @Override
    String getQuery() {
        return " MATCH (n:CatalystActivity) " +
                "WHERE NOT (n)-[:physicalEntity]->() " +
                "OPTIONAL MATCH (a)-[:created]->(n) " +
                "RETURN n.dbId AS dbId, n.displayName AS name, a.displayName AS author";
    }

    @Override
    void printResult(Result result, Path path) throws IOException {
        print(result, path, "dbId", "name", "author");
    }
}