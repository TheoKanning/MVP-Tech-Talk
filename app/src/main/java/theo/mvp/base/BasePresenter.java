package theo.mvp.base;


/**
 * Presenter with some existing functionality.
 *
 * @param <V> the view type that this presenter operates on.
 */
public abstract class BasePresenter<V> {

    private V view;

    /**
     * Called when a view is attached allowing the implementing class handle the interaction.
     */
    protected void onViewAttached() {}

    /**
     * Called when the view is detached from the presenter.
     */
    protected void onViewDetached() {}

    public final void attachView(V view) {
        this.view = view;
        onViewAttached();
    }

    public final void detachView() {
        this.view = null;
        onViewDetached();
    }

    public final boolean isViewAttached() {
        return this.view != null;
    }

    public final V getView() {
        if (isViewAttached()) {
            return this.view;
        }

        throw new ViewNotAttachedException();
    }
}