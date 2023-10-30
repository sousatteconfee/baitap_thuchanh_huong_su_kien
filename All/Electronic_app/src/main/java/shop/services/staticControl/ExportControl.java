
package shop.services.staticControl;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * "tôi sử dụng interface để ép kiểu dữ liệu"<br>
 * abstract export data
 *
 * @param <E> is entity detail
 */
public interface ExportControl<E> {

    void excelExportList(DefaultTableModel model);

    void jasperReportList(TableModel model);

    void jaspertReportDetail(E entity, Object... otherData);

}
