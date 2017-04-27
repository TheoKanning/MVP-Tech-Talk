package theo.mvp;

import theo.mvp.dagger.MvpGraph;

/**
 * Test-specific application that allows manually setting a Dagger graph to inject mocks
 */
public class TestApplication extends MvpApplication {

    public void setMvpGraph(MvpGraph mvpGraph) {
        this.component = mvpGraph;
    }
}