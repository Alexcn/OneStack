from django.conf.urls import url

from .views import WikiListView

urlpatterns = [
    url(r'^list/$', WikiListView.as_view(), name='wiki_list'),
]
