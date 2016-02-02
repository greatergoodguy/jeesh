package greatergoodguy.feature;

import greatergoodguy.jeesh.ActivityJeesh;

/**
 * Created by xuejianyu on 2/1/16.
 */
public abstract class Feature_Base {

    protected final String TAG = getClass().getSimpleName();

    private ActivityJeesh.ActivityJeeshAssistant assistant;

    public Feature_Base(ActivityJeesh.ActivityJeeshAssistant assistant) {
        this.assistant = assistant;
    }

    protected ActivityJeesh.ActivityJeeshAssistant getAssistant() {
        return assistant;
    }
}
