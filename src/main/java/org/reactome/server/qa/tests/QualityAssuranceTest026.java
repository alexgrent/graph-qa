package org.reactome.server.qa.tests;

import org.neo4j.ogm.model.Result;
import org.reactome.server.qa.QATest;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 08.03.16.
 */
@SuppressWarnings("unused")
@QATest
public class QualityAssuranceTest026 extends QualityAssuranceAbstract {

    @Override
    String getName() {
        return "HumanEventsWithCyclicPrecedingEvents";
    }

    @Override
    String getQuery() {
        return "Match (n)-[r:precedingEvent]->(x),(n)<-[e]-(x),(n)-[:species]->(s),(n)<-[:created]-(a) " +
                "Where s.displayName=\"Homo sapiens\" RETURN DISTINCT(n.dbId) AS dbIdA,n.stId AS stIdA, " +
                "n.displayName AS nameA, x.dbId AS dbIdB, x.stId AS stIdB, x.displayName AS nameB, a.displayName AS author";
    }

    @Override
    void printResult(Result result, Path path) throws IOException {
        print(result,path,"dbIdA","stIdA","nameA","dbIdB","stIdB","nameB","author");
    }
}

