from django.shortcuts import render
from django.views.generic import View, ListView, CreateView
from apps.common.utils import LoginRequiredMixin
from .models import Wiki


class WikiListView(LoginRequiredMixin, ListView):
    model = Wiki
    template_name = 'wikis/wiki_list.html'


class WikiAddView(LoginRequiredMixin, View):
    pass


class WikiEditView(LoginRequiredMixin, View):
    pass


class WikiDetailView(LoginRequiredMixin, View):
    pass
