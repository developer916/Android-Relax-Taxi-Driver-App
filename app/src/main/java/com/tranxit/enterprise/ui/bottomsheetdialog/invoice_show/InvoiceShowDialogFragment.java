package com.tranxit.enterprise.ui.bottomsheetdialog.invoice_show;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tranxit.enterprise.driver.R;
import com.tranxit.enterprise.base.BaseBottomSheetDialogFragment;
import com.tranxit.enterprise.data.network.model.Payment;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.tranxit.enterprise.base.BaseActivity.DATUM_history_detail;


public class InvoiceShowDialogFragment extends BaseBottomSheetDialogFragment implements InvoiceShowDialogIView {

    @BindView(R.id.btnClose)
    Button btnClose;
    Unbinder unbinder;
    @BindView(R.id.lblBookingid)
    TextView lblBookingid;
    @BindView(R.id.lblTotal)
    TextView lblTotal;
    @BindView(R.id.customer_payable_amount)
    TextView customerPayableAmount;
    @BindView(R.id.provider_earnings)
    TextView providerEarnings;

    NumberFormat numberFormat = getNumberFormat();

    public InvoiceShowDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_invoice_show_dialog;
    }

    @Override
    public void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        if (DATUM_history_detail != null) {
            lblBookingid.setText(DATUM_history_detail.getBookingId());

            Payment payment = DATUM_history_detail.getPayment();
            if (payment != null) {
                lblTotal.setText(numberFormat.format(payment.getPayable()));
                customerPayableAmount.setText(numberFormat.format(payment.getPayable()));
                providerEarnings.setText(numberFormat.format(payment.getProviderPay()));
            }
        }
    }


    @OnClick(R.id.btnClose)
    public void onViewClicked() {
        dismissAllowingStateLoss();
    }

    @Override
    public void onError(Throwable e) {

    }
}
