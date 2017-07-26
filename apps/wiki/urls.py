from django.conf.urls import url

from .views import WikiListView, WikiAddView, WikiDetailView, WikiEditView

urlpatterns = [
    url(r'^list/$', WikiListView.as_view(), name='wiki_list'),
    url(r'^add/$', WikiAddView.as_view(), name='wiki_add'),
    url(r'^detail/$', WikiDetailView.as_view(), name='wiki_detail'),
    url(r'^edit/$', WikiEditView.as_view(), name='wiki_edit'),
]
