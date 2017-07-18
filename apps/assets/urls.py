from django.conf.urls import url
from .views import AssetListView

urlpatterns = [
    url(r'^list/$', AssetListView.as_view(), name='dashboard'),
    url(r'^add/$', AssetListView.as_view(), name='dashboard'),
]
