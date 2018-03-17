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
public class QualityAssuranceTest027 extends QualityAssuranceAbstract {

    @Override
    public String getName() {
        return "EntriesWithOtherCyclicRelations";
    }

    @Override
    String getQuery() {
        return " MATCH (n)-[r]->(x)-[e]->(n) " +
                "WHERE NOT TYPE(r) IN [\"hasEncapsulatedEvent\", \"precedingEvent\", \"inferredTo\"] " + //precedingEvent and inferredTo are reported in QA25 and AQ26
                "      AND TYPE(r) = TYPE(e) " +
                "      OR NOT (n)-[:author|created|edited|modified|revised|reviewed|inferredTo|hasPart|precedingEvent|hasEncapsulatedEvent]-(x) " +
                "OPTIONAL MATCH (a)-[:created]->(n) " +
                "OPTIONAL MATCH (m)-[:modified]->(n) " +
                "RETURN DISTINCT(n.dbId) AS dbIdA,n.stId AS stIdA, n.displayName AS nameA, TYPE(r) AS AtoB, TYPE(e) AS BtoA, x.dbId AS dbIdB, x.stId AS stIdB, x.displayName AS nameB, a.displayName AS created, m.displayName AS modified " +
                "ORDER BY created, modified, stIdA, dbIdA, stIdB, dbIdB";
    }

    @Override
    void printResult(Result result, Path path) throws IOException {
        print(result, path, "dbIdA", "stIdA", "nameA", "AtoB", "BtoA", "dbIdB", "stIdB", "nameB", "created", "modified");
    }
}

