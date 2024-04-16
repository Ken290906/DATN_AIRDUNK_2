package print;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import print_model.ParametReportPayment;

public class ReportManager {

    private static ReportManager instance;

    private JasperReport reportPay;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    private ReportManager() {

    }

    public void complieReport() throws JRException {
        reportPay = JasperCompileManager.compileReport(getClass().getResourceAsStream("/print/inHDViewHD.jrxml"));
    }

    public void printReportManager(ParametReportPayment param) throws JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("maHD", param.getMaHD());
        parameters.put("maNV", param.getMaNV());
        parameters.put("tongTien", param.getTongTien());
        parameters.put("maqr", param.getMaqr());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(param.getFileds());
        JasperPrint print = JasperFillManager.fillReport(reportPay, parameters, dataSource);
        view(print);
    }
    
    private void view(JasperPrint print) {
        JasperViewer.viewReport(print, false);
    }
}
