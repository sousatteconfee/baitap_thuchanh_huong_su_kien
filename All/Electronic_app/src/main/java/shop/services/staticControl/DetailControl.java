
package shop.services.staticControl;

import shop.views.windows.frame_ViewControl;

/**
 * @see EntityControl
 * @see Category
 * @see Product
 * @see User
 *
 * @param <E> is entity
 */
public interface DetailControl<E> {

    /**
     * @param e to show detail dialog
     */
    void showDialogDetail(E e);

    /**
     * @see frame_ViewControl#navigator(shop.views.windows.frame_ViewControl.N_TYPE,
     * java.lang.Object)
     * @see frame_ViewControl#crud(shop.views.windows.frame_ViewControl.C_TYPE,
     * java.lang.Object)
     *
     * @param root set root to using <b>navigator</b> and <b>crud</b> in root
     */
    void setRoot(frame_ViewControl root);

    /**
     * @param e to show detail
     */
    void setDetail(E e);
}
