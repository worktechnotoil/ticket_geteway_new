package com.technotoil.ticket.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.technotoil.ticket.home.CustomerDetailModel
import com.technotoil.ticket.homefragments.BottomModel
import com.technotoil.ticket.homefragments.eventdetailscreen.EventModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.TicketsQuentitymodel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.AddOneModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.PromoModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.ApplyedModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.OrderSummaryModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.PaymentFailedModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.PaymentModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.PaymentSuccessModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.addwalletamount.SelectPaymentMethodModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.addwalletamount.WalletAddSuccessModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.mobileverifications.OtpModel
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.mobileverifications.PhoneVerificationModel
import com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent.artistactivity.ArtistModel
import com.technotoil.ticket.homefragments.sidemenufragments.artists.orginizer.orgizeactivity.OrginizerModel
import com.technotoil.ticket.homefragments.sidemenufragments.artists.trendingvenues.VenuesModel
import com.technotoil.ticket.ui.forgotPassword.ForgotPasswordViewModel
import com.technotoil.ticket.ui.getStarted.GetStartedViewModel
import com.technotoil.ticket.ui.otpVerify.OtpVrifyModel
import com.technotoil.ticket.ui.reset.ResetModel
import com.technotoil.ticket.ui.signIn.LoginModel
import com.technotoil.ticket.ui.signIn.SignInViewModel
import com.technotoil.ticket.ui.signIn.meargescreens.MeargeModel
import com.technotoil.ticket.ui.signUp.CreateAccountModel
import com.technotoil.ticket.ui.signUp.SignUpViewModel
import com.technotoil.ticket.ui.splash.SplashViewModel
import com.technotoil.ticket.ui.welcomeUser.WelcomeViewModel

class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel() as T
            }
            modelClass.isAssignableFrom(WelcomeViewModel::class.java) -> {
                WelcomeViewModel() as T
            }
            modelClass.isAssignableFrom(GetStartedViewModel::class.java) -> {
                GetStartedViewModel() as T
            }
            modelClass.isAssignableFrom(SignInViewModel::class.java) -> {
                SignInViewModel() as T
            }
            modelClass.isAssignableFrom(SignUpViewModel::class.java) -> {
                SignUpViewModel() as T
            }
            modelClass.isAssignableFrom(OtpVrifyModel::class.java) -> {
                OtpVrifyModel() as T
            }
            modelClass.isAssignableFrom(CreateAccountModel::class.java) -> {
                CreateAccountModel() as T
            }
            modelClass.isAssignableFrom(LoginModel::class.java) -> {
                LoginModel() as T
            }


            modelClass.isAssignableFrom(CustomerDetailModel::class.java) -> {
                CustomerDetailModel() as T
            }
            modelClass.isAssignableFrom(ForgotPasswordViewModel::class.java) -> {
                ForgotPasswordViewModel() as T
            }
            modelClass.isAssignableFrom(MeargeModel::class.java) -> {
                MeargeModel() as T
            }
            modelClass.isAssignableFrom(ResetModel::class.java) -> {
                ResetModel() as T
            }
            modelClass.isAssignableFrom(BottomModel::class.java) -> {
                BottomModel() as T
            }

            modelClass.isAssignableFrom(EventModel::class.java) -> {
                EventModel() as T
            }
            modelClass.isAssignableFrom(TicketsQuentitymodel::class.java) -> {
                TicketsQuentitymodel() as T
            }
            modelClass.isAssignableFrom(ArtistModel::class.java) -> {
                ArtistModel() as T
            }

                    modelClass.isAssignableFrom(OrginizerModel::class.java) -> {
                        OrginizerModel() as T
            }
            modelClass.isAssignableFrom(VenuesModel::class.java) -> {
                VenuesModel() as T
            }
            modelClass.isAssignableFrom(AddOneModel::class.java) -> {
                AddOneModel() as T
            }
            modelClass.isAssignableFrom(PromoModel::class.java) -> {
                PromoModel() as T
            }
            modelClass.isAssignableFrom(ApplyedModel::class.java) -> {
                ApplyedModel() as T
            }
            modelClass.isAssignableFrom(OrderSummaryModel::class.java) -> {
                OrderSummaryModel() as T
            }
            modelClass.isAssignableFrom(PaymentModel::class.java) -> {
                PaymentModel() as T
            }
            modelClass.isAssignableFrom(PaymentSuccessModel::class.java) -> {
                PaymentSuccessModel() as T
            }
            modelClass.isAssignableFrom(SelectPaymentMethodModel::class.java) -> {
                SelectPaymentMethodModel() as T
            }

            modelClass.isAssignableFrom(PaymentFailedModel::class.java) -> {
                PaymentFailedModel() as T
            }
            modelClass.isAssignableFrom(WalletAddSuccessModel::class.java) -> {
                WalletAddSuccessModel() as T
            }
            modelClass.isAssignableFrom(PhoneVerificationModel::class.java) -> {
                PhoneVerificationModel() as T
            }
            modelClass.isAssignableFrom(OtpModel::class.java) -> {
                OtpModel() as T
            }




            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}