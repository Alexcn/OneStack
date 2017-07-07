from django.conf.urls import url

from .views import LoginView, LogoutView

urlpatterns = [
    url(r'^account/login/$', LoginView.as_view(), name='login'),
    url(r'^account/logout/$', LogoutView.as_view(), name='logout'),
]
