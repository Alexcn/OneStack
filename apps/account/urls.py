from django.conf.urls import url

from .views import LoginView, LogoutView, DashBoardView

urlpatterns = [
    url(r'^$', DashBoardView.as_view(), name='dashboard'),
    # url(r'^account/login/$', LoginView.as_view(), name='login'),
    # url(r'^account/logout/$', LogoutView.as_view(), {'next_page': '/'}, name='logout'),
]
