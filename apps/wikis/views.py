from django.shortcuts import render
from django.views.generic import View
from apps.common.utils import LoginRequiredMixin


class WikiListView(LoginRequiredMixin, View):
    pass


class WikiAddView(LoginRequiredMixin, View):
    pass


class WikiEditView(LoginRequiredMixin, View):
    pass
