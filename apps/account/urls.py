from django.conf.urls import url

from .views import DashBoardView, UserListView, UserAddView, UserEditView, UserDetailView

urlpatterns = [
    url(r'^$', DashBoardView.as_view(), name='dashboard'),
    url(r'^user/list/$', UserListView.as_view(), name='user_list'),
    url(r'^user/add/$', UserAddView.as_view(), name='user_add'),
    url(r'^user/edit/(?P<pk>[0-9]+)/$', UserEditView.as_view(), name='user_edit'),
    url(r'^user/detail/(?P<pk>[0-9]+)/$', UserDetailView.as_view(), name='user_detail'),
]
